package com.axelor.program.web;

import com.axelor.program.db.Program;
import com.axelor.program.service.HelloService;
import com.axelor.inject.Beans;
import com.axelor.meta.schema.actions.ActionView;
import com.axelor.meta.schema.actions.ActionView.ActionViewBuilder;
import com.axelor.rpc.ActionRequest;
import com.axelor.rpc.ActionResponse;
import com.google.common.base.Joiner;
import com.google.inject.persist.Transactional;
import java.util.Arrays;
import java.util.List;
import javax.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloController {

    protected Logger log = LoggerFactory.getLogger(getClass());

    @Inject private HelloService service;

    public void hello(ActionRequest req, ActionResponse res){
         res.setFlash(service.hello());
    };

    /*public void say(ActionRequest request, ActionResponse response) {

        Program program = request.getContext().asType(Program.class);
        String message = service.say(program);

        if (program.getAddresses() != null) {
            int total = program.getAddresses().size();
            int selected = 0;
            for (Address it : program.getAddresses()) {
                if (it.isSelected()) {
                    selected++;
                }
            }
            message +=
                    "<br>"
                            + String.format(
                            "You have selected %s record(s) from total %s address records.", selected, total);
        }

        log.info("send greetings to: ${contact.fullName}");
        response.setFlash(message);
    }*/

    /*public void about(ActionRequest request, ActionResponse response) {

        Address address = request.getContext().asType(Address.class);
        Contact contact = request.getContext().getParent().asType(Contact.class);

        String name = contact.getFullName();

        if (name == null) {
            name = contact.getFirstName();
        }

        String message = "Where are you from ?";
        if (address.getCountry() != null)
            message = String.format("'%s' is a beautiful country!", address.getCountry().getName());

        if (name != null) {
            message = String.format("Welcome '%s'...</br>", name) + message;
        }

        response.setFlash(message);
    }

    public void guessEmail(ActionRequest request, ActionResponse response) {

        Contact contact = request.getContext().asType(Contact.class);

        if (contact.getEmail() == null) {

            String email =
                    Joiner.on(".").skipNulls().join(contact.getFirstName(), contact.getLastName())
                            + "@gmail.com";
            List<Address> addresses = createAddresses();

            response.setValue("email", email.toLowerCase());
            response.setValue("addresses", addresses);
        }
    }

    private List<Address> createAddresses() {

        Country frCountry =
                Beans.get(CountryRepository.class).all().filter("self.code = ?", "FR").fetchOne();

        if (frCountry == null) {
            frCountry = createDefaultCountry();
        }

        return Arrays.asList(
                new Address("My", "Home", "Paris", frCountry),
                new Address("My", "Office", "Paris", frCountry));
    }

    @Transactional
    protected Country createDefaultCountry() {
        log.debug("creating a Country record: { code: \"FR\", name: \"France\"}");

        Country frCountry = new Country("FR", "France");
        return Beans.get(CountryRepository.class).save(frCountry);
    }

    public void showHomePage(ActionRequest request, ActionResponse response) {

        response.setView(ActionView.define("Axelor.com").add("html", "http://www.axelor.com/").map());
    }

    public void showCompanyList(ActionRequest request, ActionResponse response) {

        Contact contact = request.getContext().asType(Contact.class);
        ActionViewBuilder builder = ActionView.define("All Companies").model(Company.class.getName());

        if (contact.getCompany() != null) {
            builder.domain(
                    "self.code = '"
                            + contact.getCompany().getCode()
                            + "' OR self.parent.code = '"
                            + contact.getCompany().getCode()
                            + "'");
        }

        response.setView(builder.map());
    }*/
}
