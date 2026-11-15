
import requests

def get_bitcoin_price():

    url = "https://api.coingecko.com/api/v3/simple/price"

    params = {
        "ids": "bitcoin",
        "vs_currencies": "usd,inr,eur"
    }

    try:
        response = requests.get(url, params=params, timeout=10)
        response.raise_for_status()

        data = response.json()

        bitcoin = data["bitcoin"]

        print("\n===== BITCOIN PRICE TRACKER =====")
        print("Bitcoin Price in USD: $", bitcoin["usd"])
        print("Bitcoin Price in INR: ₹", bitcoin["inr"])
        print("Bitcoin Price in EUR: €", bitcoin["eur"])
        print("=================================")

    except requests.RequestException as e:
        print("Error fetching cryptocurrency price:", e)


get_bitcoin_price()
