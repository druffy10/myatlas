import React from 'react';
import { View, StyleSheet } from 'react-native';
import AIChatComponent from './components/AIChatComponent';

const ChatScreen = () => {
  const sendMessageToAI = async (message) => {
    // Пример отправки сообщения ИИ и получения ответа
    const response = await fetch('https://your-backend-api.com/chat', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify({ message }),
    });
    const data = await response.json();
    return data.reply; // Предполагается, что в ответе есть поле `reply`
  };

  return (
    <View style={styles.container}>
      <AIChatComponent sendMessageToAI={sendMessageToAI} />
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
  },
});

export default ChatScreen;
