// Copyright 2010 Nathaniel Harward
//
// This file is part of ndh-commons.
//
// ndh-commons is free software: you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// ndh-commons is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
// GNU General Public License for more details.
//
// You should have received a copy of the GNU General Public License
// along with ndh-commons. If not, see <http://www.gnu.org/licenses/>.

package us.harward.commons.xml.saxbp.handlers;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElement;

import us.harward.commons.xml.jaxbtest.rolodex.ContactList;
import us.harward.commons.xml.saxbp.annotations.JAXBHandler;
import us.harward.commons.xml.saxbp.annotations.SAXBPHandler;

@SAXBPHandler
public class JAXBContactListHandler {

    private final Collection<ContactList> contacts = new LinkedList<ContactList>();

    @JAXBHandler(@XmlElement(namespace = "http://us.harward.xmlns/rolodex", name = "contacts"))
    public void handleContact(final JAXBElement<ContactList> element) {
        contacts.add(element.getValue());
    }

    public Collection<ContactList> getContacts() {
        return Collections.unmodifiableCollection(contacts);
    }

    public void reset() {
        contacts.clear();
    }

}