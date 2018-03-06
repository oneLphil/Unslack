import { InMemoryDbService } from 'angular-in-memory-web-api';

export class InMemoryDataService implements InMemoryDbService {
  createDb() {
    const room = {
      {id: 123},
      {name: "gpa 4.0"},
      {slackers = [
        { id: 11, name: 'Mr. Nice', score: 1},
        { id: 12, name: 'Narco', score: 1 },
        { id: 13, name: 'Bombasto', score: 1 },
        { id: 14, name: 'Celeritas', score: 1 },
        { id: 15, name: 'Magneta', score: 1 },
        { id: 16, name: 'RubberMan', score: 1 },
        { id: 17, name: 'Dynama', score: 1 },
        { id: 18, name: 'Dr IQ', score: 1 },
        { id: 19, name: 'Magma', score: 1 },
        { id: 20, name: 'Tornado', score: 1 }
      ]}
    }
    return {room};
  }
}
