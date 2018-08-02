package com.javafortesters.pulp.html.gui.entitycrud.createPages;

import com.javafortesters.pulp.html.gui.snippets.PageSnippets;
import com.javafortesters.pulp.html.templates.MyTemplate;
import com.javafortesters.pulp.reader.ResourceReader;

public class CreatePublisherPage {

    private String output="";

    public void setOutput(final String output) {
        this.output=output;
    }

    public String asHTMLString() {

        StringBuilder pageOutput = new StringBuilder();

        pageOutput.append(new PageSnippets().getPageHead("Book Search"));
        pageOutput.append(new PageSnippets().getDropDownMenu());

        String pageToRender = new ResourceReader().asString("/web/apps/pulp/page-template/entity-crud/create/create-book-publisher-content.html");

        MyTemplate template = new MyTemplate(pageToRender);

        template.replace("<!-- OUTPUT GOES HERE -->", output);
        //template.replace("<!-- FOOTER GOES HERE -->", new ResourceReader().asString("/web/apps/pulp/page-template/reports-list-widget.html"));

        pageOutput.append(template.toString());
        pageOutput.append(new PageSnippets().getPageFooter());
        return pageOutput.toString();


    }

}
