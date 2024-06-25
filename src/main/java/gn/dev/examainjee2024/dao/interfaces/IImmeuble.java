package gn.dev.examainjee2024.dao.interfaces;

import gn.dev.examainjee2024.entity.Apartment;
import gn.dev.examainjee2024.entity.Immeuble;
import gn.dev.examainjee2024.entity.User;

import java.util.List;

public interface IImmeuble {
    public List<Immeuble> getImmeubles();
    public Immeuble getImmeubleById(long id);
    public int addImmeuble(Immeuble immeuble);
    public int updateImmeuble(Immeuble immeuble);
    public int deleteImmeuble(long id);
    public List<Apartment> getImmeubleAppartments();
    public User getImmeubleOwner();
}
