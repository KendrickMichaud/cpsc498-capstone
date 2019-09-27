package core;

import core.ClassFeature;

import java.util.List;

//Background class contains all details necessary for the character to function properly
//Everything is strings but the additionalFeatures class is a list that contains features such
//as Skill Proficiencies, Languages, Equipment, or other pertinent data that is not fluff.
public class Background{
    String title;
    List<ClassFeature> additionalFeatures;
    String personalityTrait;
    String ideal;
    String bond;
    String flaw;
}