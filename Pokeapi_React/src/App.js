/**
 * The root component of the application. It serves as the entry point and renders the Pokémon list feature.
 *
 * @component
 * @returns {JSX.Element} - The main application component that includes the `PokemonList`.
 */
import PokemonList from "./pokemon/PokemonList";

function App() {
  return (
    <div className="App">
      <PokemonList />
    </div>
  );
}

export default App;
