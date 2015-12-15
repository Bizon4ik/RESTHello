package hello.Controllers;


import hello.Models.Contacts;
import hello.Services.RESTHelloService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RESTHelloController implements InitializingBean {

    @Autowired
    RESTHelloService restHelloService;

    @RequestMapping(value = "/hello/contacts", method = RequestMethod.GET, produces="application/json")
    public ResponseEntity<List<Contacts>> getFiltredContacts(@RequestParam String nameFilter){

        try {

            List<Contacts> contactsList =null;

            if (nameFilter == null || nameFilter.equals("")){
                return new ResponseEntity<List<Contacts>> (contactsList, HttpStatus.BAD_REQUEST);
            }else {
                contactsList = restHelloService.getFiltredNames(nameFilter);
            }

            return new ResponseEntity<List<Contacts>> (contactsList, HttpStatus.OK);

        }catch (Exception e) {
            return  new ResponseEntity<List<Contacts>>(HttpStatus.BANDWIDTH_LIMIT_EXCEEDED);
        }
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        restHelloService.savePreliminaryContacts();
    }
}
