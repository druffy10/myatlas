import React from 'react';
import { View, Text, StyleSheet, FlatList } from 'react-native';

const ReviewComponent = ({ reviews }) => {
  return (
    <View style={styles.container}>
      <Text style={styles.title}>Reviews</Text>
      <FlatList
        data={reviews}
        keyExtractor={(item) => item.id.toString()}
        renderItem={({ item }) => (
          <View style={styles.reviewContainer}>
            <Text style={styles.reviewerName}>{item.reviewerName}</Text>
            <Text style={styles.reviewText}>{item.reviewText}</Text>
            <Text style={styles.rating}>Rating: {item.rating}/5</Text>
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
  reviewContainer: {
    padding: 8,
    backgroundColor: '#f9f9f9',
    borderRadius: 8,
    marginBottom: 8,
  },
  reviewerName: {
    fontSize: 16,
    fontWeight: 'bold',
  },
  reviewText: {
    fontSize: 14,
    color: '#666',
    marginVertical: 4,
  },
  rating: {
    fontSize: 14,
    color: '#888',
  },
});

export default ReviewComponent;
