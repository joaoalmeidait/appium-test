# Guia de Referência Rápida: Automação Android com Appium

Este documento é um guia de referência rápido com os comandos e conceitos essenciais para a automação de testes em aplicativos Android usando **Appium**.
Seguir documentação oficial para instalar o appium: [Appium Docs](https://appium.io/docs/en/latest/quickstart/install/).
---

## 📑 Sumário
1. [Gerenciamento do Emulador](#1-gerenciamento-do-emulador)  
2. [Instalação e Informações do App](#2-instalação-e-informações-do-app)  
3. [Comandos do Servidor Appium](#3-comandos-do-servidor-appium)  
4. [Comandos de Automação (no Código)](#4-comandos-de-automação-no-código)  

---

## 1. Gerenciamento do Emulador

Comandos essenciais para iniciar, conectar e gerenciar seus dispositivos virtuais Android.

| Comando | Descrição |
|---------|-----------|
| `adb devices` | Lista todos os dispositivos e emuladores conectados ao seu computador. |
| `emulator -avd <nome-do-avd>` | Inicia um emulador pelo nome (ex: `emulator -avd Pixel_3a_API_29`). |
| `adb kill-server && adb start-server` | Força o reinício do servidor **adb**. Use em casos de falha de conexão. |

---

### 2. Instalação e Informações do App

Comandos úteis para instalar o seu aplicativo e obter as informações necessárias para as suas **Desired Capabilities**.

| Comando | Descrição |
|---------|-----------|
| `adb install-multiple <arquivos.apk>` | Instala um pacote de APKs (split APKs), necessário para apps modernos. |
| `adb push <origem> <destino>` | Copia um arquivo do seu computador para o emulador. |
| `adb shell dumpsys window \| grep -E 'mCurrentFocus'` | Retorna o **package** e a **activity** do aplicativo que está em primeiro plano no emulador. Fundamental para configurar as capacidades do Appium. |

---

## 3. Comandos do Servidor Appium

O comando principal para iniciar o servidor Appium, a ponte entre o seu código de teste e o emulador.

| Comando | Descrição |
|---------|-----------|
| `appium` | Inicia o servidor Appium na porta padrão (4723). Deve ser o primeiro passo antes de rodar qualquer teste. |

---

## 4. Comandos de Automação (no Código)

Esses são os comandos que você usará no seu código **Java** para controlar o emulador e interagir com o app.

### ✍️ Ações de Digitação e Teclado

```java
// Oculta o teclado virtual
driver.hideKeyboard();

// Simula o pressionar da tecla Enter
driver.pressKey(new KeyEvent(AndroidKey.ENTER));

// Simula o pressionar da tecla Voltar
driver.pressKey(new KeyEvent(AndroidKey.BACK));
