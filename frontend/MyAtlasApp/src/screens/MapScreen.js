import React, { useState } from 'react';
import { View } from 'react-native';
import MapComponent from './components/MapComponent';

const MapScreen = () => {
  const [selectedPlace, setSelectedPlace] = useState(null);

  const places = [
    { id: 1, name: 'Place 1', description: 'Description 1', latitude: 37.78825, longitude: -122.4324 },
    { id: 2, name: 'Place 2', description: 'Description 2', latitude: 37.78925, longitude: -122.4344 },
    // другие места
  ];

  const handlePlaceSelect = (place) => {
    setSelectedPlace(place);
    console.log('Selected place:', place);
  };

  return (
    <View style={{ flex: 1 }}>
      <MapComponent places={places} onPlaceSelect={handlePlaceSelect} />
      {/* Можно добавить дополнительную логику и отображение */}
    </View>
  );
};

export default MapScreen;
