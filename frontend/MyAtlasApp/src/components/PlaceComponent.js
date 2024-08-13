import React from 'react';
import { View, Text, Image, StyleSheet } from 'react-native';

const PlaceComponent = ({ place }) => {
  return (
    <View style={styles.container}>
      <Image source={{ uri: place.image }} style={styles.image} />
      <Text style={styles.title}>{place.name}</Text>
      <Text style={styles.description}>{place.description}</Text>
      <Text style={styles.details}>Rating: {place.rating}/5</Text>
      <Text style={styles.details}>Address: {place.address}</Text>
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    padding: 16,
    backgroundColor: '#fff',
    borderRadius: 8,
    shadowColor: '#000',
    shadowOpacity: 0.1,
    shadowOffset: { width: 0, height: 2 },
    shadowRadius: 8,
    elevation: 3,
    marginVertical: 8,
  },
  image: {
    width: '100%',
    height: 200,
    borderRadius: 8,
  },
  title: {
    fontSize: 20,
    fontWeight: 'bold',
    marginVertical: 8,
  },
  description: {
    fontSize: 16,
    color: '#666',
    marginBottom: 8,
  },
  details: {
    fontSize: 14,
    color: '#888',
  },
});

export default PlaceComponent;
