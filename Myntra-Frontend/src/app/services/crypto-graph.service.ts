import { Injectable } from '@angular/core';
import * as CryptoJS from 'crypto-js';


@Injectable({
  providedIn: 'root'
})
export class CryptoGraphService {

  cipherKey = 'TOUISS#$f5345c8c9fd30cb9CHK3097#';
  encrypted: any = "";
  decrypted!: string;
  base64Key!:string;
  constructor() { }

  encryptUsingAES256(fieldToEncrypt: any) {
    let key = CryptoJS.enc.Utf8.parse(this.cipherKey);
    let iv = CryptoJS.enc.Utf8.parse(this.cipherKey);
    let encrypted = CryptoJS.AES.encrypt(
      fieldToEncrypt, key, {
      keySize: 32,
      iv: iv,
      mode: CryptoJS.mode.ECB,
      padding: CryptoJS.pad.Pkcs7
    });
    this.encrypted = encrypted.toString();
    return this.encrypted;

  }
  decryptUsingAES256(fieldTodecrypt: any) {
    let key = CryptoJS.enc.Utf8.parse(this.cipherKey);
    let iv = CryptoJS.enc.Utf8.parse(this.cipherKey);

    this.decrypted = CryptoJS.AES.decrypt(
      fieldTodecrypt, key, {
      keySize: 32,
      iv: iv,
      mode: CryptoJS.mode.ECB,
      padding: CryptoJS.pad.Pkcs7
    }).toString(CryptoJS.enc.Utf8);
    return this.decrypted;
  }
  // async generateAESKey() {
  //   const key = await window.crypto.subtle.generateKey(
  //     {
  //       name: "AES-GCM",
  //       length: 256, // Key length can be 128, 192, or 256 bits
  //     },
  //     true, // Whether the key is extractable (i.e., can be used in exportKey)
  //     ["encrypt", "decrypt"] // Key usages
  //   );
  //   return key;
  // }
  // async exportKey(key: any) {
  //   const exported = await window.crypto.subtle.exportKey(
  //     "raw", // Export the key in raw format
  //     key
  //   );
  //   return exported;
  // }

  // arrayBufferToBase64(buffer: any) {
  //   let binary = '';
  //   const bytes = new Uint8Array(buffer);
  //   const len = bytes.byteLength;
  //   for (let i = 0; i < len; i++) {
  //     binary += String.fromCharCode(bytes[i]);
  //   }
  //   return window.btoa(binary);
  // }
  // async generateAndExportKey() {
  //   const key = await this.generateAESKey();
  //   const exportedKey = await this.exportKey(key);
  //   this.base64Key = this.arrayBufferToBase64(exportedKey);
  //   // console.log("Base64 Encoded Key:", base64Key);
  // }
}
