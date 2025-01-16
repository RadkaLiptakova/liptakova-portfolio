import "bootstrap/dist/css/bootstrap.min.css"
import React, { useState, useEffect } from 'react';
import { apiGet } from '../utils/api';
import PokemonCard from "./PokemonCard";

/**
 * A React component that displays a list of Pokemon fetched from the PokeAPI.
 * Users can navigate through paginated Pokemon lists and select a Pokemon to view its details.
 *
 * @component
 * @returns {JSX.Element} - A component that renders a paginated Pokémon list and a selected Pokémon's details.
 *
 * @description
 * - Fetches Pokémon data from the PokéAPI and displays it as a list.
 * - Provides navigation buttons to move between pages of Pokémon.
 * - Clicking on a Pokémon name selects it, displaying its details in the `PokemonCard` component.
 */
function PokemonList() {

    const [data, setData] = useState({ pokemons: [], nextUrl: "", previousUrl: "" });
    const [url, setUrl] = useState('https://pokeapi.co/api/v2/pokemon');
    const [isLoading, setIsLoading] = useState(true);
    const [selectedPokemon, setSelectedPokemon] = useState('bulbasaur');

    useEffect(() => {
        /**
        * Fetches Pokémon data from the API and updates the component state.
        * 
        * @returns {Promise<void>} - A promise that resolves when the data has been fetched and state is updated.
        */
        async function fetchPokemons() {
            setIsLoading(true);
            const data = await apiGet(url);
            setData({
                pokemons: data.results,
                nextUrl: data.next,
                previousUrl: data.previous,
            });
            setIsLoading(false);
        };

        fetchPokemons();
    }, [url]);


    /**
     * Handles navigation between Pokémon pages.
     *
     * Updates the current API URL to fetch the next or previous page of Pokémon.
     *
     * @param {string} url - The URL of the next or previous page of Pokémon.
     * @returns {void}
     */
    function handleNavigationClick(url) {
        if (!url) return;
        setUrl(url);
    }

    return (
        <div>
            <div className="container text-center my-3">
                <button type="button" className="btn btn-primary me-1" onClick={() => handleNavigationClick(data.previousUrl)}>Previous</button>
                <button type="button" className="btn btn-primary" onClick={() => handleNavigationClick(data.nextUrl)}>Next</button>
            </div>
            <div className="container-fluid">
                <div className="row">
                    <div className="col">
                        {isLoading ? (
                            <div className="text-center my-3">
                                <div className="spinner-border" role="status">
                                    <span className="visually-hidden">Loading...</span>
                                </div>
                            </div>
                        ) : (
                            <ul>
                                {data.pokemons.map((pokemon) => (
                                    <li key={pokemon.name} onClick={() => setSelectedPokemon(pokemon.name)} style={{ cursor: 'pointer' }} className="link-primary">
                                        {pokemon.name}
                                    </li>
                                ))}
                            </ul>
                        )}
                    </div>
                    {selectedPokemon && (
                        <div className="col">
                            <PokemonCard pokemonName={selectedPokemon} />
                        </div>
                    )}
                </div>
            </div>
        </div>

    );
}

export default PokemonList;