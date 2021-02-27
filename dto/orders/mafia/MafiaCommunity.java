package station.pizza.dto.orders.mafia;

import java.util.LinkedList;
import java.util.List;

public class MafiaCommunity {

    public static void main(String[] args) {

        // saveMafiaDTO - це обєкт, який приймає MafiaCommunity із id bossa та списком гангстерів
        final SaveMafiaDTO saveMafiaDTO = new SaveMafiaDTO();
        // вказуємо id bossa, який завжди буде однаковим
        saveMafiaDTO.setBossId(1);

        // створюємо список гангстерів
        List<Gangster> gangs = new LinkedList<>();

        // створ 2 гангстера та передаємо їх у список
        Gangster gangster = new Gangster();
        gangster.setName("Pedro");
        gangster.setNickname("Cruel");
        gangster.setSkill(80);

        gangs.add(gangster);
        gangs.add(new Gangster("Dan", "B52", 75));

        // в обєкт мафії присвоюємо список гангстерів
        saveMafiaDTO.setGangs(gangs);

        // передається уже заповнений обєкт saveMafiaDTO із босом і гангстерами
        acceptGangsters(saveMafiaDTO);
    }

    private static void acceptGangsters(SaveMafiaDTO saveMafiaDTO) {
        System.out.println("The boos is " + saveMafiaDTO.getBossId());
        System.out.println();
        final List<Gangster> gangs = saveMafiaDTO.getGangs();
        for (Gangster elem : gangs) {
            System.out.println("Name " + elem.getName());
            System.out.println("Nickname " + elem.getNickname());
            System.out.println("Skills " + elem.getSkill());
            System.out.println();
        }

        System.out.println("Accepted");
    }
}
