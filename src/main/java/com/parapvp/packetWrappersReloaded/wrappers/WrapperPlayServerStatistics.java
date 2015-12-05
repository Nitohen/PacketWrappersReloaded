/*
 *  PacketWrapper - Contains wrappers for each packet in Minecraft.
 *  Copyright (C) 2012 Kristian S. Stangeland
 *
 *  This program is free software; you can redistribute it and/or modify it under the terms of the 
 *  GNU Lesser General Public License as published by the Free Software Foundation; either version 2 of 
 *  the License, or (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 *  without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. 
 *  See the GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License along with this program; 
 *  if not, write to the Free Software Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 
 *  02111-1307 USA
 */

package com.parapvp.packetWrappersReloaded.wrappers;

import java.util.Map;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.WrappedStatistic;
import com.parapvp.packetWrappersReloaded.AbstractPacket;

public class WrapperPlayServerStatistics extends AbstractPacket {
    public static final PacketType TYPE = PacketType.Play.Server.STATISTICS;
    
    public WrapperPlayServerStatistics() {
        super(new PacketContainer(TYPE), TYPE);
        handle.getModifier().writeDefaults();
    }
    
    public WrapperPlayServerStatistics(PacketContainer packet) {
        super(packet, TYPE);
    }
    
    /**
     * Retrieve a map of every statistic in this packet.
     * <p>
     * Note that you must write back the map to save any changes.
     * @return Map of every statistics sent to the player.
    */
    public Map<WrappedStatistic, Integer> getStatistics() {
        return handle.getStatisticMaps().read(0);
    }
    
    /**
     * Set every statistic and associated integer value to send to the player.
     * @param changes - the changed map of statistics and data.
     */
    public void setStatistics(Map<WrappedStatistic, Integer> changes) {
        handle.getStatisticMaps().write(0, changes);
    }
}
