import React from 'react';
import { View, Text, StyleSheet, FlatList } from 'react-native';

const RouteComponent = ({ route }) => {
  return (
    <View style={styles.container}>
      <Text style={styles.title}>{route.name}</Text>
      <Text style={styles.description}>{route.description}</Text>
      <Text style={styles.details}>Distance: {route.distance} km</Text>

      <FlatList
        data={route.places}
        keyExtractor={(item) => item.id.toString()}
        renderItem={({ item }) => (
          <View style={styles.placeContainer}>
            <Text style={styles.placeName}>{item.name}</Text>
            <Text style={styles.placeDescription}>{item.description}</Text>
          </View>
        )}
      />
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
  title: {
    fontSize: 20,
    fontWeight: 'bold',
    marginBottom: 8,
  },
  description: {
    fontSize: 16,
    color: '#666',
    marginBottom: 8,
  },
  details: {
    fontSize: 14,
    color: '#888',
    marginBottom: 8,
  },
  placeContainer: {
    padding: 8,
    backgroundColor: '#f9f9f9',
    borderRadius: 8,
    marginBottom: 8,
  },
  placeName: {
    fontSize: 16,
    fontWeight: 'bold',
  },
  placeDescription: {
    fontSize: 14,
    color: '#666',
  },
});

export default RouteComponent;
