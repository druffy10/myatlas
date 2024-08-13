import React, { useState } from 'react';
import { View, Text, TextInput, Button, FlatList, StyleSheet, KeyboardAvoidingView, Platform } from 'react-native';

const AIChatComponent = ({ sendMessageToAI }) => {
  const [messages, setMessages] = useState([]);
  const [inputText, setInputText] = useState('');

  const handleSend = async () => {
    if (inputText.trim() === '') return;

    const userMessage = { id: Date.now(), text: inputText, sender: 'user' };
    setMessages([...messages, userMessage]);
    setInputText('');

    // Отправка сообщения ИИ и получение ответа
    const aiResponse = await sendMessageToAI(inputText);
    const aiMessage = { id: Date.now() + 1, text: aiResponse, sender: 'ai' };
    setMessages((prevMessages) => [...prevMessages, aiMessage]);
  };

  const renderItem = ({ item }) => (
    <View style={[styles.messageContainer, item.sender === 'ai' ? styles.aiMessage : styles.userMessage]}>
      <Text style={styles.messageText}>{item.text}</Text>
    </View>
  );

  return (
    <KeyboardAvoidingView
      behavior={Platform.OS === 'ios' ? 'padding' : 'height'}
      style={styles.container}
    >
      <FlatList
        data={messages}
        keyExtractor={(item) => item.id.toString()}
        renderItem={renderItem}
        contentContainerStyle={styles.chatContainer}
      />
      <View style={styles.inputContainer}>
        <TextInput
          style={styles.textInput}
          placeholder="Type a message..."
          value={inputText}
          onChangeText={setInputText}
        />
        <Button title="Send" onPress={handleSend} />
      </View>
    </KeyboardAvoidingView>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#f0f0f0',
  },
  chatContainer: {
    padding: 16,
  },
  messageContainer: {
    padding: 10,
    borderRadius: 10,
    marginVertical: 4,
    maxWidth: '75%',
  },
  userMessage: {
    alignSelf: 'flex-end',
    backgroundColor: '#0084ff',
  },
  aiMessage: {
    alignSelf: 'flex-start',
    backgroundColor: '#e5e5ea',
  },
  messageText: {
    color: '#fff',
  },
  inputContainer: {
    flexDirection: 'row',
    alignItems: 'center',
    padding: 10,
    backgroundColor: '#fff',
    borderTopWidth: 1,
    borderTopColor: '#ccc',
  },
  textInput: {
    flex: 1,
    height: 40,
    borderColor: '#ccc',
    borderWidth: 1,
    borderRadius: 20,
    paddingHorizontal: 10,
    marginRight: 10,
  },
});

export default AIChatComponent;
