package com.myntra.constants;

public class MyntraConstants {
	public static final String ROLE_ID = "id";
	public static final String PRETOKEN_URL = "https://merchant.dev.toucanus.net/api/auth/pretokenize";
	public static final String TOKEN_URL = "https://merchant.dev.toucanus.net/api/auth/newextuserlogin";
	public static final String DUMMY_JSON_FOR_PRETOKEN = "{{\"headers\":{\"normalizedNames\":{},\"lazyUpdate\":null}}";
	
//	public static final String DUMMY_JSON_FOR_PRETOKEN = "{ \"ngo\" : \"true\"}";
// encryption and decryption constants
    public static final String ENCRYPT_DECRYPT_INSTANCE = "AES/ECB/PKCS5Padding";
	public static final String ENCRYPTION_FALSE = "Error while encrypting: ";
	public static final String DECRYPTION_FALSE = "Error while decrypting: ";
	public static final String SECRETKEYSPEC = "AES";

	// encryption/decryption key
	public static final String SECRET_KEY="TOUISS#$f5345c8c9fd30cb9CHK3097#";
	public static final String ENCODED_KEY="ahoTlY6G4C7JpZnXxXRWgP5fXCe4P6p2n1WnxpTHZEM=";
}
