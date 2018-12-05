package DataObjects;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import com.google.gson.Gson;
import Common.Common.FileReaderManager;
import Common.Common.Utilities;
import DataObjects.Ticket;;

public class JsonDataReader {

	private final String ticketFilePath = Utilities.getProjectPath()
			+ FileReaderManager.getInstance().getConfigReader().getTestDataResourcePath() + "ticket.json";
	private Ticket ticket;

	public JsonDataReader() {
		ticket = getTicketInfo();
	}

	public Ticket getTicketInfo() {
		Gson gson = new Gson();
		BufferedReader bufferReader = null;
		try {
			try {
				bufferReader = new BufferedReader(new InputStreamReader(new FileInputStream(ticketFilePath),"UTF-8"));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ticket = gson.fromJson(bufferReader, Ticket.class);
			return ticket;
		} catch (FileNotFoundException e) {
			throw new RuntimeException("Json file not found at path : " + ticketFilePath);
		} finally {
			try {
				if (bufferReader != null)
					bufferReader.close();
			} catch (IOException ignore) {
			}
		}
	}

}
