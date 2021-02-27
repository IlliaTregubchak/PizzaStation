package station.pizza.dto.orders.mafia;

public class Gangster {
    private String name;
    private String nickname;
    private int skill;

    public Gangster() {
    }

    public Gangster(String name, String nickname, int skill) {
        this.name = name;
        this.nickname = nickname;
        this.skill = skill;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getSkill() {
        return skill;
    }

    public void setSkill(int skill) {
        this.skill = skill;
    }
}
