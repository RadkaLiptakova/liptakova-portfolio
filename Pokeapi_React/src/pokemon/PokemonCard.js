import React, { useState, useEffect } from "react";
import { apiGet } from '../utils/api'
import "./PokemonCard.css";
import TYPE_COLORS from "../utils/typeColors";

/**
 * A React functional component that displays detailed information about a specific Pokemon.
 * Fetches Pokemon data from the PokeAPI based on the given Pokemon name and renders it in a styled card.
 *
 * @component
 * @param {Object} props - Component props.
 * @param {string} props.pokemonName - The name of the Pokemon to fetch and display.
 * @returns {JSX.Element} - A styled card displaying the Pokemon's image, name, types, weight, and height.
 *
 * @description
 * - Uses the `pokemonName` prop to fetch data for a specific Pokémon.
 * - Displays a loading spinner while fetching data.
 * - Dynamically styles Pokemon type badges using colors defined in `TYPE_COLORS`.
 */
function Card({ pokemonName }) {
    const [pokemon, setPokemon] = useState(null);
    const [isLoading, setIsLoading] = useState(true);

    useEffect(() => {

        /**
         * Fetches detailed Pokémon data from the PokéAPI and updates the state.
         *
         * @returns {Promise<void>} - A promise that resolves when the Pokémon data is fetched and stored in state.
         */
        async function fetchPokemon() {
            setIsLoading(true);
            const pokemonData = await apiGet(`https://pokeapi.co/api/v2/pokemon/${pokemonName}`);
            setPokemon(pokemonData);
            setIsLoading(false);
        };

        fetchPokemon();
    }, [pokemonName]);

    return (
        <div className="card" style={{ width: "15rem", height: "20rem" }}>
            {isLoading ? (
                <div className="text-center my-3">
                    <div className="spinner-border" role="status">
                        <span className="visually-hidden">Loading...</span>
                    </div>
                </div>
            ) : (
                <div className="text-center">
                    <img src={pokemon.sprites.front_default} className="card-img-top" alt="" />
                    <div className="card-body">
                        <h4 className="card-title text-center text-uppercase fw-bold">{pokemon.name}</h4>
                        {pokemon.types.map((type) => {
                            return (
                                <span
                                    key={type.type.name}
                                    className="badge text-white me-1"
                                    style={{ backgroundColor: TYPE_COLORS[type.type.name] }}
                                >
                                    {type.type.name}
                                </span>
                            );
                        })}
                        <p className="card-text">
                            <small>Weight: {pokemon.weight}</small><br />
                            <small>Height: {pokemon.height}</small><br />
                        </p>
                    </div>
                </div>
            )}
        </div>
    );
}

export default Card