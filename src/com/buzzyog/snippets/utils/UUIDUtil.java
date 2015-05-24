package com.buzzyog.snippets.utils;

import com.mojang.api.profiles.HttpProfileRepository;
import com.mojang.api.profiles.Profile;
import lombok.Getter;

public class UUIDUtil {
    private static final String AGENT = "minecraft";

    public UUIDUtil(String user, UUIDCallback callback) {
        HttpProfileRepository repository = new HttpProfileRepository(AGENT);
        UUIDRunner uuidRunner = new UUIDRunner(repository, user, callback);
        new Thread(uuidRunner).start();
    }

    public static class UUIDRunner implements Runnable {
        private final HttpProfileRepository httpProfileRepository;
        @Getter private final String username;
        @Getter private String uuid;
        @Getter private UUIDCallback callback;

        public UUIDRunner(HttpProfileRepository httpProfileRepository, String username, UUIDCallback callback) {
            this.httpProfileRepository = httpProfileRepository;
            this.username = username;
            this.callback = callback;
        }

        @Override
        public void run() {
            Profile[] profiles = httpProfileRepository.findProfilesByNames(username);
            if (profiles[0] == null) {
                this.uuid = null;
            } else {
                uuid = profiles[0].getId();
                uuid = String.format("%s-%s-%s-%s-%s", uuid.substring(0, 8),
                        uuid.substring(8, 12), uuid.substring(12, 16),
                        uuid.substring(16, 20), uuid.substring(20, 32));
            }
            callback.complete(username, uuid);
        }
    }

    public static interface UUIDCallback {
        public void complete(String username, String uuid);
    }
}