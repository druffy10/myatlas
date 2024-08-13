import React from 'react';
import { View, ScrollView } from 'react-native';
import RouteComponent from './components/RouteComponent';

const RouteScreen = () => {
  const route = {
    name: 'Golden Gate Tour',
    description: 'A scenic tour around the Golden Gate Bridge.',
    distance: 12.5,
    places: [
      { id: 1, name: 'Golden Gate Bridge', description: 'A famous suspension bridge.' },
      { id: 2, name: 'Fort Point', description: 'A historic fort at the Golden Gate.' },
      { id: 3, name: 'Baker Beach', description: 'A popular beach with views of the bridge.' },
    ],
  };

  return (
    <ScrollView>
      <View style={{ padding: 16 }}>
        <RouteComponent route={route} />
        {/* Здесь можно добавить дополнительные компоненты или информацию */}
      </View>
    </ScrollView>
  );
};

export default RouteScreen;
