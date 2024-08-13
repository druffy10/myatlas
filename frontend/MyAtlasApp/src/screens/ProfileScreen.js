import React, { useState } from 'react';
import { View, Text, TextInput, Button, StyleSheet, Alert } from 'react-native';

export default function ProfileScreen({ navigation }) {
  const [username, setUsername] = useState('John Doe');
  const [email, setEmail] = useState('john.doe@example.com');
  const [bio, setBio] = useState('Traveler, Photographer, Adventurer.');

  const handleSave = () => {
    // Здесь можно добавить логику для сохранения изменений профиля пользователя.
    // Например, отправка обновленных данных на сервер.

    Alert.alert('Profile Saved', 'Your profile has been updated.');
  };

  const handleLogout = () => {
    // Логика выхода из аккаунта. Например, очистка токена и перенаправление на экран входа.

    Alert.alert('Logged Out', 'You have been logged out.');
    navigation.navigate('LoginScreen'); // Перенаправление на экран входа
  };

  return (
    <View style={styles.container}>
      <Text style={styles.title}>Profile</Text>

      <TextInput
        style={styles.input}
        placeholder="Username"
        value={username}
        onChangeText={setUsername}
      />

      <TextInput
        style={styles.input}
        placeholder="Email"
        value={email}
        onChangeText={setEmail}
        keyboardType="email-address"
      />

      <TextInput
        style={styles.input}
        placeholder="Bio"
        value={bio}
        onChangeText={setBio}
        multiline
      />

      <Button title="Save Changes" onPress={handleSave} />
      <Button title="Logout" color="red" onPress={handleLogout} />
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    padding: 16,
    backgroundColor: '#f8f8f8',
  },
  title: {
    fontSize: 24,
    marginBottom: 16,
    textAlign: 'center',
  },
  input: {
    height: 40,
    borderColor: '#ccc',
    borderWidth: 1,
    marginBottom: 12,
    paddingHorizontal: 8,
  },
});
