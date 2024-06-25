package gn.dev.examainjee2024.webServlet.models;

import gn.dev.examainjee2024.entity.Immeuble;
import gn.dev.examainjee2024.entity.Location;
import gn.dev.examainjee2024.entity.Payment;
import gn.dev.examainjee2024.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserModel {
    private String keyWord;
    private List<User> users;
    private List<Immeuble> immeubles = null;
    private List<Location> locations = null;
    private List<Payment> payments = null;
}
