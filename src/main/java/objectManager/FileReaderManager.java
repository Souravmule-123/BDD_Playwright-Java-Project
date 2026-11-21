package objectManager;

import dataReader.ConfigFileReader;

public class FileReaderManager {

    private static final FileReaderManager instance = new FileReaderManager();
    private ConfigFileReader configFileReader;

    private FileReaderManager() {}

    public static FileReaderManager getInstance() {
        return instance;
    }

    public ConfigFileReader getConfigReader() {
        if (configFileReader == null) {
            configFileReader = new ConfigFileReader();
        }
        return configFileReader;
    }
}