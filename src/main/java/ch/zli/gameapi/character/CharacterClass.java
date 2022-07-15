package ch.zli.gameapi.character;

public enum CharacterClass {
    CASTER("CASTER"), DEFENDER("DEFENDER"), GUARD("GUARD"), MEDIC("MEDIC"),
    SNIPER("SNIPER"), SPECIALIST("SPECIALIST"), SUPPORTER("SUPPORTER"), VANGUARD("VANGUARD");

    public static final CharacterClass[] ALL = {CASTER, DEFENDER, GUARD, MEDIC, SNIPER, SPECIALIST, SUPPORTER, VANGUARD};

    private final String name;

    private CharacterClass(final String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return getName();
    }
}
