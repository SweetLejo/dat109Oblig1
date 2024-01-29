package org.example.math;

public record Vector2(double x, double y) {

	/**
	 * Point by point subtraction for each value in the vectors.
	 * @param other vector to subtract with.
	 * @return result in a new vector
	 */
	public Vector2 minus(Vector2 other) {
		return new Vector2(this.x - other.x, this.y - other.y);
	}
	
	/**
	 * Point by point summation for each value in the vector.
	 * @param other vector to add with.
	 * @return result in a new vector
	 */
	public Vector2 plus(Vector2 other) {
		return new Vector2(this.x + other.x, this.y + other.y);
	}
	
	/**
	 * Finds the angle in which this vector is pointing.
	 * @return angle in radians
	 */
	public double angle() {
		return Math.atan2(y, x);
	}
	
	/**
	 * @return magnitude of this vector
	 */
    public double magnitude() {
        return Math.sqrt(magnitudeSquared());
    }

    /**
     * Used in magnitude().
     * @return magnitude raised by the power of 2
     */
    public double magnitudeSquared() {
        return x * x + y * y;
    }
    
    /**
     * Multiplies each value in the vector with given scale. Scales magnitude
     * of vector.
     * @param scale to multiply values with with
     * @return result in a new vector
     */
    public Vector2 scaled(double scale) {
    	if(isZero()) {
    		return new Vector2(0, 0);
    	}
    	
        return new Vector2(x * scale, y * scale);
    }

    /**
     * Scales the values in the vector, such the vectors magnitude is equals to
     * the given target magnitude.
     * @param targetMagnitude to scale vector to
     * @return result in a new vector
     */
    public Vector2 scaledToMagnitude(double targetMagnitude) {
        double scaleRequired = targetMagnitude / magnitude();
        
        return scaled(scaleRequired);
    }
	
    /**
     * Normalizes the values in the vector to be between 0 and 1.
     * @return result in a new vectors
     */
    public Vector2 normalized() {
        return this.scaled(1 / magnitude());
    }

    /**
     * @return true if all values in this vector are 0.
     */
    public boolean isZero() {
        return x == 0 && y == 0;
    }
	
    /**
     * Finds a vector perpendicular (90 degrees) to this vector.
     * @return result in a new vector
     */
    public Vector2 perpendicular() {
    	return new Vector2(y, -x);
    }
    
    /**
     * Finds dot product of the two vectors.
     * @param other vector
     * @return dot product
     */
    public double dot(Vector2 other) {
        return this.x * other.x + this.y * other.y;
    }
	
}
