package station.pizza.dto.orders.mafia;

import java.util.List;

public class SaveMafiaDTO {
    private long bossId;
    private List<Gangster> gangs;

    public long getBossId() {
        return bossId;
    }

    public void setBossId(long bossId) {
        this.bossId = bossId;
    }

    public List<Gangster> getGangs() {
        return gangs;
    }

    public void setGangs(List<Gangster> gangs) {
        this.gangs = gangs;
    }
}
