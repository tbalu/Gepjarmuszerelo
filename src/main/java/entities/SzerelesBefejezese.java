package entities;

import java.time.LocalDate;

/**
 * Szereles befejezese viselkedest modellezo interfesz.
 */

public interface SzerelesBefejezese {
    void setSzerelesBefejezese(LocalDate BefejezesIdeje);
    LocalDate getSzerelesBefejezese();
    void setMunkavegzesKoltsege(Integer MunkavegzesKoltsege);
    Integer getMunkavegzesKoltsege();
}
