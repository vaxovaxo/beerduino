package org.tensin.beerduino;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;


/**
 * <sensor id="1" value="27" type="C" seuil="30" />.
 *
 * @author u248663
 */
@Root(name = "sensor")
public class TemperatureResult {

    /** The temperature. */
    @Attribute(name = "value")
    private double temperature;

    /** The sensor id. */
    @Attribute(name = "id")
    private String sensorId;

    /** The type. */
    @Attribute(required = false)
    private String type = "C";

    /** The limit. */
    @Attribute(name = "seuil", required = false)
    private double limit = Double.NaN;

    /**
     * Instantiates a new temperature result.
     */
    public TemperatureResult() {
        super();
    }

    /**
     * Instantiates a new temperature result.
     *
     * @param sensorId the sensor id
     * @param temperature the temperature
     */
    public TemperatureResult(final String sensorId, final double temperature) {
        super();
        this.temperature = temperature;
        this.sensorId = sensorId;
    }

    /**
     * Gets the limit.
     *
     * @return the limit
     */
    public double getLimit() {
        return limit;
    }

    /**
     * Gets the sensor id.
     *
     * @return the sensor id
     */
    public String getSensorId() {
        return sensorId;
    }

    /**
     * Gets the state.
     *
     * @return the state
     */
    public TemperatureState getState() {
        if (temperature >= limit) {
            return TemperatureState.OVERHEAT;
        } else {
            return TemperatureState.NORMAL;
        }
    }

    /**
     * Gets the temperature.
     *
     * @return the temperature
     */
    public double getTemperature() {
        return temperature;
    }

    /**
     * Gets the type.
     *
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the limit.
     *
     * @param limit the new limit
     */
    public void setLimit(final double limit) {
        this.limit = limit;
    }

    /**
     * Sets the sensor id.
     *
     * @param sensorId the new sensor id
     */
    public void setSensorId(final String sensorId) {
        this.sensorId = sensorId;
    }

    /**
     * Sets the temperature.
     *
     * @param temperature the new temperature
     */
    public void setTemperature(final double temperature) {
        this.temperature = temperature;
    }

    /**
     * Sets the type.
     *
     * @param type the new type
     */
    public void setType(final String type) {
        this.type = type;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Temp [").append(temperature).append("], sensorId [").append(sensorId).append("], seuil [").append(limit).append("]");
        return sb.toString();
    }
}