package yeonji.worldcup;


/* FoodDB의 기본생성자, getter, setter, toString 만들어둔 클래스 */

public class Pokemon {
    private String pokemonName; /* 포켓몬 이름*/

    public Pokemon() {
    }

    public Pokemon(String pokemonName) {
        this.pokemonName = pokemonName;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "pokemonName='" + pokemonName + '\'' +
                '}';
    }

    public String getPokemonName() {
        return pokemonName;
    }

    public void setPokemonName(String pokemonName) {
        this.pokemonName = pokemonName;
    }
}
