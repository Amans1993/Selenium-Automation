package esignly.emailutils;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MailinatorReader {

	

	/**
	 * Retrieves email details based on inbox and message ID.
	 *
	 * @param inbox     The email inbox (without the domain).
	 * @param messageId The ID of the message to retrieve.
	 * @return The content of the email as a string.
	 * @throws IOException If there is an issue with the HTTP request.
	 */
	public static String getEmailDetails(String inbox) throws IOException {
		String link ="";
		String apiUrl = EmailConstant.API_URL;
		String apiKey = EmailConstant.API_KEY; // Replace with your actual API key
		String emailId = inbox; // Replace with the actual email ID to search for
		String emailKey = EmailConstant.EMAIL_KEY; // Replace with the actual key for email ID in the response
		String messageKey = EmailConstant.MSG_KEY; // Replace with the actual key for message ID in the response
		String messageId = EmailFetcher.fetchMessageIdByEmail(apiUrl, apiKey, emailId, emailKey, messageKey);
		String url = String.format("%s/domains/@team572791.testinator.com/inboxes/%s/messages/%s?apikey=%s",
				EmailConstant.BASE_URL, inbox, messageId, EmailConstant.API_KEY);
		System.out.println("url: " + url);
		try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
			HttpGet request = new HttpGet(
					"https://api.mailinator.com/v2/domains/@team572791.testinator.com/inboxes/aman/messages/"
							+ messageId + "/links");
			request.setHeader("Authorization", "Bearer " + EmailConstant.API_KEY);
			try (CloseableHttpResponse response = httpClient.execute(request)) {
				int statusCode = response.getStatusLine().getStatusCode();
				System.out.println("statusCode: " + statusCode);
				if (statusCode == 200) {
					String responseBody = EntityUtils.toString(response.getEntity());
					System.out.println(responseBody);
					JSONObject jsonResponse = new JSONObject(responseBody);
					System.out.println("Response Body: ");
					System.out.println("Final: " + jsonResponse.toString(4)); // Pretty print with 4-space indentation
					String jsonString = jsonResponse.toString(4);
					JSONObject jsonObject = new JSONObject(jsonString);

					// Retrieve the JSONArray associated with the "links" key
					JSONArray linksArray = jsonObject.getJSONArray("links");

					// Iterate over the JSONArray and print each link
					for (int i = 0; i < linksArray.length(); i++) {
						 link = linksArray.getString(i);
						if (link.contains("request/signdoc?request=")) {
							System.out.println("Link " + (i + 1) + ": " + link);
							break;
						}
					}

					return link;

				} else {
					throw new RuntimeException("Failed : HTTP error code : " + statusCode);
				}
			}
		}
	}

	/**
	 * Extracts all links from the email content.
	 *
	 * @param emailContent The HTML content of the email.
	 * @return A list of URLs found in the email content.
	 */
	public static List<String> extractLinksFromEmail(String emailContent) {
		List<String> links = new ArrayList<>();
		Document document = Jsoup.parse(emailContent);
		Elements anchorTags = document.select("a[href]");
		for (Element anchor : anchorTags) {
			links.add(anchor.attr("href"));
		}
		return links;
	}

	public static List<String> fetchMessageIds(String url, String apiKey, String messageKey) throws IOException {
		List<String> messageIds = new ArrayList<>();

		try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
			HttpGet request = new HttpGet(url);
			request.setHeader("Authorization", "Bearer " + apiKey); // Set the Authorization header

			try (CloseableHttpResponse response = httpClient.execute(request)) {
				// Get the response entity
				String responseBody = EntityUtils.toString(response.getEntity());

				// Parse the response as JSON
				JSONObject jsonResponse = new JSONObject(responseBody);

				// Extract message IDs from the JSON response
				JSONArray messages = jsonResponse.optJSONArray("messages");
				if (messages != null) {
					for (int i = 0; i < messages.length(); i++) {
						JSONObject message = messages.getJSONObject(i);
						String messageId = message.optString(messageKey); // Adjust key if needed
						if (messageId != null && !messageId.isEmpty()) {
							messageIds.add(messageId);
						}
					}
				}
			}
		}

		return messageIds;
	}

	public static void main(String[] args) throws IOException {
		getEmailDetails("aman");
		
//		try {
//
//			String apiUrl = EmailConstant.API_URL;
//			String apiKey = EmailConstant.API_KEY; // Replace with your actual API key
//			String emailId = "aman"; // Replace with the actual email ID to search for
//			String emailKey = EmailConstant.EMAIL_KEY; // Replace with the actual key for email ID in the response
//			String messageKey = EmailConstant.MSG_KEY; // Replace with the actual key for message ID in the response
//			messageId = EmailFetcher.fetchMessageIdByEmail(apiUrl, apiKey, emailId, emailKey, messageKey);
//			System.out.println(messageId);
//
//			// Step 1: Get email details
//			String emailContent = getEmailDetails(emailId, messageId);
//
//			// Step 2: Extract links from the email content
//			List<String> links = extractLinksFromEmail(emailContent);
//			System.out.println("links: " + links.size());
//			for (String link : links) {
//				System.out.println("Found link: " + link);
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}

}
