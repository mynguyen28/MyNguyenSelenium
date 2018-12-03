package Common.Common;

public class FileReaderManager {

	private static FileReaderManager fileReaderManager = new FileReaderManager();
	private static FileReaderConfig configFileReader;

	private FileReaderManager() {
	}

	public static FileReaderManager getInstance() {
		return fileReaderManager;
	}

	public FileReaderConfig getConfigReader() {
		return (configFileReader == null) ? new FileReaderConfig() : configFileReader;
	}

}
