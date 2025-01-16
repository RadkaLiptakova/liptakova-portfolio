/**
 * Fetches data from the specified URL using the Fetch API and returns the parsed JSON.
 *
 * @param {string} url - The URL to fetch data from.
 * @returns {Promise<Object>} - A promise that resolves to the parsed JSON data from the response.
 * @throws {Error} - Throws an error if the fetch operation fails or if the response cannot be parsed as JSON.
 */
export async function apiGet(url) {
    const response = await fetch(url);
    const data = await response.json();
    return data;
}
