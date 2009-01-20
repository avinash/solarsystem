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

/**
 * This class is the base class of the whole class hierarchy of celestial
 * bodies. Most of the basic capabilities of those bodies are defined here. Note
 * that, normally, this class should be abstract but as it is unit tested,
 * objects need to be instanciated from it.
 */

public class Body
{
    /**
     * @param name is the name of the body
     * @param mass is the mass (in kg) of the body
     */
    public Body(String name, double mass)
    {
        this.name = name;
        this.mass = mass;
    }

    public String getName()
    {
        return name;
    }

    public String getDescription()
    {
        return name;
    }

    public double getMass()
    {
        return mass;
    }

    public double getTotalMass()
    {
        return mass;
    }

    /** the name of the body */
    private String name;

    /** the mass (in kg) of the body */
    private double mass;
}