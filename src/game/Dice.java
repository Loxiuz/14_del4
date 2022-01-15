package game;

public class Dice
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

    /**
     * Rolls the dice.
     *
     * @return Value of the dice.
     */
    public int rollDice()
    {
        m_showingFace = (int) (Math.random() * m_faces) + 1;
        return m_showingFace;
    }

    public int getShowingFace()
    {
        return m_showingFace;
    }
}