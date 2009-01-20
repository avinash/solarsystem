/***************************************************************************
 *   Copyright (C) 2005 by Avinash Meetoo - avinash@uom.ac.mu              *
 *                                                                         *
 *   This program is free software; you can redistribute it and/or modify  *
 *   it under the terms of the GNU General Public License as published by  *
 *   the Free Software Foundation; either version 2 of the License, or     *
 *   (at your option) any later version.                                   *
 *                                                                         *
 *   This program is distributed in the hope that it will be useful,       *
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of        *
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the         *
 *   GNU General Public License for more details.                          *
 *                                                                         *
 *   You should have received a copy of the GNU General Public License     *
 *   along with this program; if not, write to the                         *
 *   Free Software Foundation, Inc.,                                       *
 *   59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.             *
 ***************************************************************************/

import java.io.IOException;

/**
 * This class is a text mode user interface (menu-based) allowing the user to
 * manage bodies inside a predefined star, our own (beloved) Sun...
 * 
 * @see Body
 * @see ParentBody
 */

public class TextUserInterface
{
    /**
     * the constructor builds a solar system with only the Sun
     */
    public TextUserInterface()
    {
        // Semantics:
        // topMostNaturalBody will always reference the sun, the top-most body
        // whereas currentNaturalBody will change to always indicate the natural
        // body
        // the user has selected

        topMostNaturalBody = currentNaturalBody = new Star("Sun", 1000);
    }

    /**
     * start() is the only visible method and it is called by the user
     * application to start the menu-based text user interface
     */
    public void start()
    {
        for (;;) {
            System.out.println("Main menu");
            System.out.println("---------");
            System.out.println();
            System.out.println("1. Display all details");
            System.out.println("2. Add a body");
            System.out.println("3. Remove a body");
            System.out.println("4. Change current natural body");
            System.out.println("5. Quit");
            System.out.println();
            System.out.print("=>");

            try {
                switch (getIntegerFromUser()) {
                    case 1:
                        displayAllDetails();
                        break;

                    case 2:
                        addBody();
                        break;

                    case 3:
                        removeBody();
                        break;

                    case 4:
                        changeCurrentNaturalBody();
                        break;

                    case 5:
                        return;
                }
            }

            catch (IOException e) {
                // in case there is a slight problem with the keyboard
            }

            catch (NumberFormatException e) {
                // if the user does not enter a number
            }
        }
    }

    /**
     * Displays the description of the current natural body on the screen
     */
    private void displayAllDetails()
    {
        System.out.println();
        System.out.println("Description      : "
                + currentNaturalBody.getDescription());
        System.out.println("Total Mass       : "
                + currentNaturalBody.getTotalMass());
        System.out.println();
    }

    /**
     * Add a body (any specific one) to the current natural body
     */
    private void addBody()
    {
        System.out.println();

        for (;;) {
            System.out.println("What do you want ?");
            System.out.println("------------------");
            System.out.println();
            System.out.println("1. A planet");
            System.out.println("2. A satellite");
            System.out.println("3. An artificial satellite");
            System.out.println("4. Back");
            System.out.println();
            System.out.print("=>");

            try {
                switch (getIntegerFromUser()) {
                    case 1:
                        getNameAndMassFromUser();

                        currentNaturalBody.add(new Planet(name, mass));
                        break;

                    case 2:
                        getNameAndMassFromUser();

                        currentNaturalBody.add(new Satellite(name, mass));
                        break;

                    case 3:
                        getNameAndMassFromUser();

                        currentNaturalBody.add(new ArtificialSatellite(name,
                                mass));
                        break;

                    case 4:
                        return;
                }
            }

            catch (IOException e) {
                // problem with keyword for example
            }

            catch (NumberFormatException e) {
                // if the user does not enter a number
            }

            catch (ExistingException e) {
                // the user has tried to add the same body twice

                System.out.println();
                System.out.println("ERROR! This body already exists");
                System.out.println();
            }
        }
    }

    /**
     * allows for the removal of a body from this current natural body
     */
    private void removeBody()
    {
        try {
            System.out.println();
            System.out.print("Name ? ");
            String name = getStringFromUser();

            currentNaturalBody.remove(name);
        }

        catch (IOException e) {
            // might be a problem with the keyboard
        }

        catch (NonExistingException e) {
            // the name has not been found

            System.out.println();
            System.out.println("ERROR! This name does not exist");
            System.out.println();
        }
    }

    /**
     * Allows the user to change the current natural body Remember: the top-most
     * natural body never changes
     */
    private void changeCurrentNaturalBody()
    {
        try {
            System.out.println();
            System.out.print("Name ? ");
            String name = getStringFromUser();

            // Now, we see why we need to keep a reference on the top-most body
            // It's for getReferenceOnOrbitingNaturalBody!!!
            currentNaturalBody = topMostNaturalBody
                    .getReferenceOnOrbitingNaturalBody(name);
        }

        catch (IOException e) {
            // problem with keyboard
        }

        catch (NonExistingException e) {
            // this name has not been found - and we have been looking from the
            // sun!
            System.out.println();
            System.out.println("ERROR: This name cannot be found");
            System.out.println();
        }
    }

    /**
     * Asks for the name and the mass of the new body to create
     */
    private void getNameAndMassFromUser()
    {
        try {
            System.out.println();

            System.out.print("Name ? ");
            name = getStringFromUser();
        }

        catch (IOException e) {
            // keyboard problem?
        }

        while (true) {
            try {
                System.out.print("Mass ? ");
                mass = getDoubleFromUser();
            }

            catch (IOException e) {
                // keyboard problem?
            }

            catch (NumberFormatException e) {
                // in case, the user does not enter a double
                // ask him/her once more
                continue;
            }

            // if there is no exception, the mass has been
            // correctly entered
            break;
        }
    }

    /**
     * get an integer from the user
     * 
     * @return an integer entered by the user
     * @throws IOException if there is any I/O problem
     * @throws NumberFormatException if the user does not enter an integer
     */

    private int getIntegerFromUser() throws IOException, NumberFormatException
    {
        byte line[] = new byte[1024];

        System.in.read(line);
        return Integer.parseInt((new String(line)).trim());
    }

    /**
     * get a double (floating-point number) from the user
     * 
     * @return a double
     * @throws IOException if there is any I/O problem
     * @throws NumberFormatException if the user does not enter a double
     */
    private double getDoubleFromUser() throws IOException,
            NumberFormatException
    {
        byte line[] = new byte[1024];

        System.in.read(line);
        return Double.parseDouble((new String(line)).trim());
    }

    /**
     * get a string of characters from the user
     * 
     * @return the string entered by the user
     * @throws IOException if there is any I/O problem
     */
    private String getStringFromUser() throws IOException
    {
        byte line[] = new byte[1024];

        System.in.read(line);
        return (new String(line)).trim();
    }

    /**
     * Semantics: topMostNaturalBody will always reference the sun, the top-most
     * body whereas currentNaturalBody will change to always indicate the
     * natural body the user has selected
     */
    private ParentBody topMostNaturalBody;

    private ParentBody currentNaturalBody;

    /** the name of the body to create */
    private String     name;

    /** the mass of the body to create */
    private double     mass;
}
