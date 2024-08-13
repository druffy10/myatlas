import React from 'react';
import { View, ScrollView } from 'react-native';
import PlaceComponent from './components/PlaceComponent';

const PlaceScreen = () => {
  const place = {
    name: 'Golden Gate Bridge',
    description: 'A famous suspension bridge in San Francisco.',
    image: 'https://example.com/image.jpg',
    rating: 4.8,
    address: 'San Francisco, CA',
  };

  return (
    <ScrollView>
      <View style={{ padding: 16 }}>
        <PlaceComponent place={place} />
        {/* Здесь можно добавить дополнительные компоненты или информацию */}
      </View>
    </ScrollView>
  );
};

export default PlaceScreen;
