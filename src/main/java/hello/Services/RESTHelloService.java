package hello.Services;


import hello.DAOs.RESTHelloDAO;
import hello.Models.Contacts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RESTHelloService {

    @Autowired
    RESTHelloDAO restHelloDAO;

    public void savePreliminaryContacts(){
        List<Contacts> contactsList = getInstallContactList();
        restHelloDAO.savePreliminaryContacts(contactsList);
    }

    private List<Contacts> getInstallContactList() {
        List<Contacts> list = Arrays.asList(
                new Contacts("Milan"),
                new Contacts("Malcolm"),
                new Contacts("Dion"),
                new Contacts("Romeo"),
                new Contacts("Marlyn"),
                new Contacts("Jinny"),
                new Contacts("Rodrigo"),
                new Contacts("Brad"),
                new Contacts("Rutha"),
                new Contacts("Javier"),
                new Contacts("Kasey"),
                new Contacts("Bennett"),
                new Contacts("Laila"),
                new Contacts("Gregorio"),
                new Contacts("Palmer"),
                new Contacts("Shenika"),
                new Contacts("Luna"),
                new Contacts("Sarina"),
                new Contacts("Portia"),
                new Contacts("Ada"),
                new Contacts("Flossie"),
                new Contacts("Terri"),
                new Contacts("Elvina"),
                new Contacts("Boyce"),
                new Contacts("Kamala"),
                new Contacts("Arline"),
                new Contacts("Penelope"),
                new Contacts("Maximo"),
                new Contacts("Theodore"),
                new Contacts("Alita"),
                new Contacts("Graciela"),
                new Contacts("Doloris"),
                new Contacts("Anh"),
                new Contacts("Raul"),
                new Contacts("Verlie"),
                new Contacts("Alessandra"),
                new Contacts("Bethann"),
                new Contacts("Ola"),
                new Contacts("Afton"),
                new Contacts("Dottie"),
                new Contacts("Lanora"),
                new Contacts("Beverlee"),
                new Contacts("Jaymie"),
                new Contacts("Al"),
                new Contacts("Junita"),
                new Contacts("Latina"),
                new Contacts("Vicki"),
                new Contacts("Genoveva"),
                new Contacts("Evangelina"),
                new Contacts("Janett")

        );

        return list;
    }


        public List<Contacts> getAllContacts() {
            return restHelloDAO.getAllContacts();
        }

        public List<Contacts> getFiltredNames(String nameFilter) {
                List<Contacts> allName = getAllContacts();
                List<Contacts> filtredNames = filteredNames(allName, nameFilter);
                return filtredNames;
        }

        private List<Contacts> filteredNames(List<Contacts> allName, String nameFilter) {

                if (isNamesHaveCritea(allName, nameFilter)) {
                        return allName
                                .parallelStream()
                                .filter(s -> !s.getName().matches(nameFilter) )
                                .collect(Collectors.toList());

                }else {
                        return allName;
                }

        }

        private boolean isNamesHaveCritea(List<Contacts> nameList, String filterName){
                Boolean result =  nameList
                                .parallelStream()
                                .anyMatch(s-> s.getName().matches(filterName));
                return  result;
        }
}
