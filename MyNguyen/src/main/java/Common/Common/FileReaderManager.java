package Common.Common;

import java.io.UnsupportedEncodingException;

import DataObjects.JsonDataReader;

public class FileReaderManager {

	private static FileReaderManager fileReaderManager = new FileReaderManager();
	private static FileReaderConfig configFileReader;
	private static JsonDataReader jsonDataReader;

	private FileReaderManager() {
	}

	public static FileReaderManager getInstance() {
		return fileReaderManager;
	}

	public FileReaderConfig getConfigReader() {
		return (configFileReader == null) ? new FileReaderConfig() : configFileReader;
	}

	public JsonDataReader getJsonReader() {
		try {
			return (jsonDataReader == null) ? new JsonDataReader() : jsonDataReader;
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
