package game;

public class Die
{
    /** Number of faces on the dice */
    private int m_faces;
    /** The face the dice is currently showing */
    private int m_showingFace = 1;

    /**
     * Initializes a new dice.
     *
     * @param faces Number of faces on the dice.
     */
    public Dice(int faces)
    {
        m_faces = faces;
    }

}
