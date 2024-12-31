package esignly.emailutils;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;

public class EmailFetcher {

	/**
	 * Fetches the message ID of a particular email ID.
	 *
	 * @param url        The API endpoint URL.
	 * @param apiKey     The API key for authorization.
	 * @param emailId    The email ID to search for.
	 * @param emailKey   The JSON key that represents the email ID in the response.
	 * @param messageKey The JSON key that represents the message ID in the
	 *                   response.
	 * @return The message ID of the given email ID, or null if not found.
	 * @throws IOException If there's an issue with the HTTP request.
	 */
	public static String fetchMessageIdByEmail(String url, String apiKey, String emailId, String emailKey,
			String messageKey) throws IOException {
		try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
			HttpGet request = new HttpGet(url);
			request.setHeader("Authorization", "Bearer " + apiKey); // Set the Authorization header

			try (CloseableHttpResponse response = httpClient.execute(request)) {
				// Get the response entity
				String responseBody = EntityUtils.toString(response.getEntity());

				// Print response body for debugging
				System.out.println("Response Body: " + responseBody);

				// Parse the response as JSON
				JSONObject jsonResponse = new JSONObject(responseBody);
				JSONArray messages = jsonResponse.optJSONArray("msgs");

				if (messages != null) {
					for (int i = 0; i < messages.length(); i++) {
						JSONObject message = messages.getJSONObject(i);
						String currentEmailId = message.optString(emailKey);
						if (emailId.equals(currentEmailId)) {
							return message.optString(messageKey);
						}
					}
				}
			}
		}
		return null; // Return null if email ID is not found
	}
	public static void main(String[] args) throws IOException {
		
		String url =MailinatorReader.getEmailDetails("aman");
		System.out.println(url);
	}

}
