package org.debz.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.debz.model.Person;
import org.debz.service.PersonService;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller

public class PersonListController {
    @Autowired
    private PersonService personService;

    private static final String LIST_VIEW = "personlist";
    private static final String FORM_VIEW = "createperson";

    private final Log log = LogFactory.getLog(PersonListController.class);

	@RequestMapping(value = "person.list", method = RequestMethod.GET)
	public String printPersonList(ModelMap model) {

        List<Person> persons = personService.getPersonsList();

		model.addAttribute("persons", persons);
		return LIST_VIEW;
	}
    @RequestMapping(value = "/api/users", method = RequestMethod.GET)
    public
    @ResponseBody
    String listUsersJson(ModelMap model) throws JSONException {
        JSONArray userArray = new JSONArray();
        for (Person person : personService.getPersonsList()) {
            JSONObject userJSON = new JSONObject();
            userJSON.put("id", person.getId());
            userJSON.put("names", person.getNames());
            userJSON.put("occupation", person.getOccupation());
            userJSON.put("DOB", person.getDob());
            userArray.put(userJSON);
        }
        return userArray.toString();
    }





}