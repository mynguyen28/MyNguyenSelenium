package Common.Common;

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
	
	public JsonDataReader getJsonReader(){
		 return (jsonDataReader == null) ? new JsonDataReader() : jsonDataReader;
		 }

}
