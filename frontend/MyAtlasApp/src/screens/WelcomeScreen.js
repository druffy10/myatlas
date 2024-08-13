import React from 'react';
import { View, Text, Button, StyleSheet, Image } from 'react-native';

const WelcomeScreen = ({ navigation }) => {
  return (
    <View style={styles.container}>
      <Image
        source={require('../assets/images/welcome-image.png')}
        style={styles.image}
      />
      <Text style={styles.title}>Welcome to MyAtlas</Text>
      <Text style={styles.subtitle}>Your journey starts here</Text>
      <View style={styles.buttonContainer}>
        <Button
          title="Register"
          onPress={() => navigation.navigate('RegisterScreen')}
        />
        <Button
          title="Login"
          onPress={() => navigation.navigate('LoginScreen')}
        />
      </View>
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#f8f8f8',
    padding: 16,
  },
  image: {
    width: 200,
    height: 200,
    marginBottom: 20,
  },
  title: {
    fontSize: 24,
    fontWeight: 'bold',
    color: '#333',
    marginBottom: 10,
  },
  subtitle: {
    fontSize: 18,
    color: '#666',
    marginBottom: 30,
  },
  buttonContainer: {
    width: '100%',
    justifyContent: 'space-around',
    height: 100,
  },
});

export default WelcomeScreen;
