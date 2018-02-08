import java.util.ArrayList;
import java.util.List;

/**
 * Created by Karasiówka on 2017-04-23.
 * class which describes object PLAYER
 */
public class Player {
    private String name;
    private String surname;
    private int height;
    private int age;
    private int weight;
    private List<Integer> spike = new ArrayList<Integer>();
    private List<Integer> block = new ArrayList<Integer>();
    private String possition;
    private String currentClub;
    private List<Integer> attacks = new ArrayList<Integer>();
    private List<Integer> blocks = new ArrayList<Integer>();
    private List<Integer> badAttacks = new ArrayList<Integer>();
    private List<Integer> badServices = new ArrayList<Integer>();
    private List<Integer> mistakes = new ArrayList<>();
    private List<Integer> results = new ArrayList<>();


    public Player(String name, String surname, int height, int age, int weight, int spike, int block, String possition, String currentClub) {
        this.name = name;
        this.surname = surname;
        this.height = height;
        this.age = age;
        this.weight = weight;
        this.spike.add(spike);
        this.block.add(block);
        this.possition = possition;
        this.currentClub = currentClub;
        //this.attacks.add(0);
        //this.blocks.add(0);
        //this.badAttacks.add(0);
        //this.badServices.add(0);
        //this.mistakes.add(0);
        //this.results.add(0);
    }

    public Player(String name, String surname, int height, int age, int weight, List<Integer> spike, List<Integer> block, String possition, String currentClub, List<Integer> attacks, List<Integer> blocks, List<Integer> badAttacks, List<Integer> badServices, List<Integer> mistakes) {
        this.name = name;
        this.surname = surname;
        this.height = height;
        this.age = age;
        this.weight = weight;
        this.spike = spike;
        this.block = block;
        this.possition = possition;
        this.currentClub = currentClub;
        this.attacks = attacks;
        this.blocks = blocks;
        this.badAttacks = badAttacks;
        this.badServices = badServices;
        this.mistakes = mistakes;
    }

    public Player() {
    }


    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public List<Integer> getSpike() {
        return spike;
    }

    public void setSpike(List<Integer> spike) {
        this.spike = spike;
    }

    public List<Integer> getBlock() {
        return block;
    }

    public void setBlock(List<Integer> block) {
        this.block = block;
    }

    public String getPossition() {
        return possition;
    }

    public void setPossition(String possition) {
        this.possition = possition;
    }

    public String getCurrentClub() {
        return currentClub;
    }

    public void setCurrentClub(String currentClub) {
        this.currentClub = currentClub;
    }

    public List<Integer> getAttacks() {
        return attacks;
    }

    public void setAttacks(List<Integer> attacks) {
        this.attacks = attacks;
    }

    public List<Integer> getBlocks() {
        return blocks;
    }

    public void setBlocks(List<Integer> blocks) {
        this.blocks = blocks;
    }

    public List<Integer> getBadAttacks() {
        return badAttacks;
    }

    public void setBadAttacks(List<Integer> badAttacks) {
        this.badAttacks = badAttacks;
    }

    public List<Integer> getBadServices() {
        return badServices;
    }

    public void setBadServices(List<Integer> badServices) {
        this.badServices = badServices;
    }

    public List<Integer> getMistakes() {
        return mistakes;
    }

    public void setMistakes(List<Integer> mistakes) {
        this.mistakes = mistakes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getResults() {
        return results;
    }

    public void setResults(List<Integer> results) {
        this.results = results;
    }

    public void addAttacks(int attacks ){
        this.attacks.add(attacks);
    }

    public void addBlocks(int blocks){
        this.blocks.add(blocks);
    }

    public void addBadAttacks(int badAttacks){
        this.badAttacks.add(badAttacks);
    }

    public void addBadServices(int badServices){
        this.badServices.add(badServices);
    }

    public void addMistakes(int mistakes){
        this.mistakes.add(mistakes);
    }

    public void addResults(int results){
        this.results.add(results);
    }
    public void addSpike(int spike){
        this.spike.add(spike);
    }
    public void addBlock(int block){
        this.block.add(block);
    }
}
