package com.example.FitnessApp.util;

import java.security.KeyStore;

public class GenerateKeystore {
    public static void main(String[] args) {
        try {
            KeyStore keyStore = SelfSignedCertificateGenerator.generateSelfSignedCertificate();
            SelfSignedCertificateGenerator.saveKeyStore(keyStore, "keystore.jks", "password");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

