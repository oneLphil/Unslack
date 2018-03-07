import {
  MatButtonModule,
  MatCheckboxModule,
  MatTabsModule,
  MatListModule,
  MatToolbarModule,
  MatCardModule,
  MatGridListModule
} from '@angular/material';

import { NgModule } from '@angular/core';

@NgModule({
    imports: [MatButtonModule, MatButtonModule, MatCheckboxModule, MatTabsModule, MatListModule, MatToolbarModule, MatCardModule, MatGridListModule],
    exports: [MatButtonModule, MatButtonModule, MatCheckboxModule, MatTabsModule, MatListModule, MatToolbarModule, MatCardModule, MatGridListModule]
})

export class MaterialModule {}
